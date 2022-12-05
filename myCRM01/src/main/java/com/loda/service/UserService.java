package com.loda.service;

import com.loda.base.BaseService;
import com.loda.base.ResultInfo;
import com.loda.dao.UserMapper;
import com.loda.dao.UserRoleMapper;
import com.loda.entity.po.CusDevPlan;
import com.loda.entity.po.User;
import com.loda.entity.po.UserRole;
import com.loda.entity.vo.UserModel;
import com.loda.utils.AssertUtil;
import com.loda.utils.Md5Util;
import com.loda.utils.PhoneUtil;
import com.loda.utils.UserIDBase64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/21 15:27
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService extends BaseService<User, Integer> {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    public UserModel login(String userName, String userPwd) {
        UserModel userModel = new UserModel();

        //参数非空判断
        AssertUtil.isTrue(StringUtils.isBlank(userName) || StringUtils.isBlank(userPwd), "用户名或密码不能为空");

        //根据用户名调用dao层查询数据库
        User user = userMapper.selectUserByUserName(userName);
        //如果user对象不存在，返回错误信息，用户不存在
        AssertUtil.isTrue(user == null, "用户不存在或已注销!");

        //如果用户存在，判断密码，密码不正确抛异常
        AssertUtil.isTrue(!Md5Util.encode(userPwd).equals(user.getUserPwd()), "密码不正确");

        //用户存在，密码正确，则登陆成功
//        userModel.setId(user.getId());
        //加密用户id
        userModel.setIdStr(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        return userModel;
    }

    /**
     Service层
         1。接收四个参数（用户ID、原始密码、新密码、确认密码)
         2．通过用户ID查询用户记录，返回用户对象
         3，参数校验
             待更新用户记录是否存在(用户对象是否为空)
             判断原始密码是否为空
             判断原始密码是否正确(查询的用户对象中的用户密码是否原始密码一致)
             判断新密码是否为空
             判断新密码是否与原始密码一致(不允许新密码与原始密码)
             判断确认密码是否为空
             判断确认密码是否与新密码一致
         4.设置用户的新密码
            需要将新密码通过指定算法进行加密(md5加密)
         5.执行更新操作，判断受影响的行数
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @param repeatPwd
     */
    public void updatePwd(Integer userId, String oldPwd, String newPwd, String repeatPwd){
        //1。接收四个参数（用户ID、原始密码、新密码、确认密码)
        //2．通过用户ID查询用户记录，返回用户对象
        User user = userMapper.selectByPrimaryKey(userId);
        //3，参数校验
        //待更新用户记录是否存在(用户对象是否为空)
        AssertUtil.isTrue(user == null, "待修改记录不存在");
        //判断原始密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(oldPwd),"原始密码不能为空");
        //  判断原始密码是否正确(查询的用户对象中的用户密码是否跟原始密码一致)，防止其他人（非本人）修改密码
        AssertUtil.isTrue(!Md5Util.encode(oldPwd).equals(user.getUserPwd()), "原始密码不正确");
        //判断新密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(newPwd), "新密码不能为空");
        //判断新密码是否与原始密码一致(不允许新密码与原始密码一样)
        AssertUtil.isTrue(oldPwd.equals(newPwd), "新旧密码不能一样");
        AssertUtil.isTrue(StringUtils.isBlank(repeatPwd), "确认密码不能为空");
        AssertUtil.isTrue(!newPwd.equals(repeatPwd), "两次新密码不一致");

        //4.设置用户的新密码
        //需要将新密码通过指定算法进行加密(md5加密)
        user.setUserPwd(Md5Util.encode(newPwd));

        // 5.执行更新操作，判断受影响的行数
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) != 1, "更新失败");
    }

    /**
     * 查询所有销售人员
     * @return
     */
    public List<Map<String, Object>> selectAllSales() {
        return userMapper.selectAllSales();
    }

    /**
     * 添加用户
     * 1: 参数校验
     *      用户名userName     非空，唯一性
     *      邮箱email          非空
     *      手机号phone        非空，格式正确
     * 2：设置参数的默认值
     *      isValid         1
     *      createDate      系统当前时间
     *      updateDate      系统当前时间
     *      默认密码          md5加密123456
     * 3：执行添加操作，判断受影响的行数
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user){
        checkUserParams(user.getUserName(), user.getEmail(), user.getPhone(), null);
        //2：设置参数的默认值
        user.setIsValid(1);
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        user.setUserPwd(Md5Util.encode("123456"));

        //3：执行添加操作，判断受影响的行数
        //由于要判断主键，主键的返回值是大于1的，所以判断条件要改为小于1
        AssertUtil.isTrue(userMapper.insertSelective(user) < 1, "用户添加失败");

        //用户角色关联
        relationUserRole(user.getId(), user.getRoleIds());
    }

    /**
     * 用户角色关联
     *      添加操作
     *          原始角色不存在
     *               1。不添加新的角色记录 不操作用户角色表
     *               2。添加新的角色记录 给指定用户绑定相关的角色记录
     *      更新操作
     *          原始角色不存在
     *              1。不添加新的角色记录 不操作用户角色表
     *              2。添加新的角色记录 给指定用户绑定相关的角色记录
     *          原始角色存在
     *              1。添加新的角色记录
     *                  判断已有的角色记录,添加没有的角色记录
     *              2。清空所有的角色记录
     *                  删除用户绑定角色记录
     *              3。移除部分角色记录
     *                  删除不存在的角色记录，存在的角色记录保留
     *              4。移除部分角色，添加新的角色
     *                  删除不存在的角色记录，存在的角色记录保留,添加新的角色
     *  情况太多，如何进行统一的角色分配处理？？
     *          判断用户对应的角色记录存在，先将用户原有的角色记录删陈，再添加新的角色记录
     *      删除操作
     *          删除指定用户绑定的角色记录
     */
    private void relationUserRole(Integer userId, String roleIds) {
        //通过用户ID查询角色记录
        Integer count = userRoleMapper.countUserRoleByUserId(userId);
        //判断角色记录是否存在
        if (count > 0) {
            //如果角色记录存在，则删除该用户对应的角色记录
            AssertUtil.isTrue(userRoleMapper.deleteUserRoleByUserId(userId) != count, "用户角色分配失败！");
        }
        //判断角色ID是否存在，如果存在，则添加该用户对应的角色记录
        if (StringUtils.isNotBlank(roleIds)) {
            //将用户角色数据设置到集合中，执行批量添加
            List<UserRole> userRoleList = new ArrayList<>();
            //将角色ID字符串转换成数组
            String[] roleIdsArray = roleIds.split(",");
            //遍历数组，得到对应的用户角色对象,并设置到集合中
            for (String roleId : roleIdsArray) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(Integer.parseInt(roleId));
                userRole.setUserId(userId);
                userRole.setCreateDate(new Date());
                userRole.setUpdateDate(new Date());
                //设置到集合中
                userRoleList.add(userRole);
            }
            //批量添加用户角色记录
            AssertUtil.isTrue(userRoleMapper.insertBatch(userRoleList)!=userRoleList.size(), "用户角色分配失败！");
        }

    }

    /**
     *更新用户
     *1，参数校验*
            判断用户工D是否为空,且数据存在
            用户名userName  非空，唯一性
            邮箱email  非空
            手机号phone 非空，格式正确
     2。设置参数的默认值
            updateDate  系统当前时间
     *3。托行更新操作，判断受影响的行数
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user){
        AssertUtil.isTrue(user.getId() == null, "待更新记录不存在！");
        User temp = userMapper.selectByPrimaryKey(user.getId());
        AssertUtil.isTrue(temp == null, "待更新记录不存在!");

        //参数校验
        checkUserParams(user.getUserName(), user.getEmail(), user.getPhone(), user.getId());

        user.setUpdateDate(new Date());

        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) !=1, "更新失败");
        //用户角色关联
        relationUserRole(user.getId(), user.getRoleIds());
    }

    /**
     * 参数校验
     * @param userName
     * @param email
     * @param phone
     * @param userId
     */
    private void checkUserParams(String userName, String email,String phone, Integer userId) {
        //参数非空判断
        AssertUtil.isTrue(StringUtils.isBlank(userName), "用户名不能为空");

        //根据用户名调用dao层查询数据库
        User user = userMapper.selectUserByUserName(userName);
        //如果user对象存在，返回错误信息，用户已存在

        //如果用户对象为空，则表示用户名可用;如果用户对象不为空，则表示用户名不可用
        //如果是添加操作，数据库中无数据，只要通过名称查到数据，则表示用户名被占用
        //如果是修改操作，数据库中有对应的记录，通过用户名查到数据，可能是当前记录本身，也可能是别的记录如果用户名存在，且与当前修改记录不是同一个，则表示其他记录占用了该用户名，不可用
        AssertUtil.isTrue(user != null && !(user.getId().equals(userId)), "用户已存在!");

        AssertUtil.isTrue(StringUtils.isBlank(email), "用户邮箱不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(phone), "用户手机号不能为空");
        AssertUtil.isTrue(!PhoneUtil.isMobile(phone), "手机号格式不正确");
    }

    /**
     * 用户删除
     * @param ids
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteByIds(Integer[] ids) {
        //判断ids是否为空，长度是否大于0
        AssertUtil.isTrue(ids == null || ids.length < 1, "待删除条目不存在！");
        //执行删除操作，判断受影响的行数
        AssertUtil.isTrue(userMapper.deleteBatch(ids) != ids.length, "删除用户失败！");

        for (Integer userId : ids) {
            Integer count = userRoleMapper.countUserRoleByUserId(userId);
            if (count > 0) {
                AssertUtil.isTrue(userRoleMapper.deleteUserRoleByUserId(userId) != count, "用户角色删除失败！");
            }
        }
    }
}
