package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.base.ResultInfo;
import com.loda.entity.po.User;
import com.loda.entity.vo.UserModel;
import com.loda.exceptions.ParamsException;
import com.loda.query.UserQuery;
import com.loda.service.UserService;
import com.loda.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/21 16:21
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public ResultInfo login(String userName, String userPwd) {
        //获取参数
        //调用service方法，获取resultInfo
        ResultInfo resultInfo = new ResultInfo();
        UserModel userModel = userService.login(userName, userPwd);
        resultInfo.setResult(userModel);
        //使用全局异常后，不用在方法中使用try捕获或处理异常
//        try {
//            UserModel userModel = userService.login(userName, userPwd);
//            resultInfo.setResult(userModel);
//        }catch (ParamsException e) {
//            resultInfo.setCode(e.getCode());
//            resultInfo.setMsg(e.getMsg());
//            e.printStackTrace();
//        } catch (Exception e) {
//            resultInfo.setCode(500);
//            resultInfo.setMsg("Exception异常，登陆失败");
//            e.printStackTrace();
//        }
        return resultInfo;
    }

    /**
     Controller层
         1。通过形参接收前端传递的参数(原始密码、新密码、确认密码)
         2．通过request对象,获取设置在cookie中的用户ID
         3，调用Service层修改密码的功能，得到ResultInfo对象
         4。返回ResultInfo对象
     Service层
         1。接收四个参数（用户ID、原始密码、新密码、确认密码)
         2．通过用户ID查询用户记录，返回用户对象
         3，参数校验
             待更新用户记录是否存在(用户对象是否为空)判断原始密码是否为空
             判断原始密码是否正确(查询的用户对象中的用户密码是否原始密码一致)判断新密码是否为空
             判断新密码是否与原始密码一致(不允许新密码与原始密码)判断确认密码是否为空
             判断确认密码是否与新密码一致
         4.设置用户的新密码
            需要将新密码通过指定算法进行加密(md5加密)
         5.执行更新操作，判断受影响的行数
     Dao层
        通过用户ID修改用户密码

     */

    @PostMapping("updatePassword")
    @ResponseBody
    public ResultInfo updatePwd(HttpServletRequest request, String oldPassword, String newPassword, String confirmPassword) {
        //1。通过形参接收前端传递的参数(原始密码、新密码、确认密码)

        ResultInfo resultInfo = new ResultInfo();

        // 2．通过request对象,获取设置在cookie中的用户ID
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request, "userIdStr");

        userService.updatePwd(userId, oldPassword, newPassword, confirmPassword);

        //使用全局异常后，不用在方法中使用try捕获或处理异常
        //3，调用Service层修改密码的功能，得到ResultInfo对象
//        try {
//            userService.updatePwd(userId, oldPassword, newPassword, confirmPassword);
//        }catch (ParamsException p){
//            resultInfo.setCode(p.getCode());
//            resultInfo.setMsg(p.getMsg());
//            p.printStackTrace();
//        }catch (Exception e){
//            resultInfo.setCode(500);
//            resultInfo.setMsg("Exception 更新密码失败");
//            e.printStackTrace();
//        }
        //4。返回ResultInfo对象
        return resultInfo;
    }

    @RequestMapping("toPasswordPage")
    public String toPasswordPage() {
        return "user/password";
    }

    /**
     * 查询所有销售人员
     * @return
     */
    @RequestMapping("selectAllSales")
    @ResponseBody
    public List<Map<String, Object>> selectAllSales() {
        return userService.selectAllSales();
    }

    /**
     * 分页多条件查询用户列表
     * @param userQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectByParams(UserQuery userQuery) {
        return userService.queryByParamsForTable(userQuery);
    }

    /**
     * 进入用户列表页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "user/user";
    }

    @PostMapping("add")
    @ResponseBody
    public ResultInfo addUser(User user) {
        userService.addUser(user);
        return success("用户添加成功");
    }

    /**
     * 打开添加或修改用户的页面
     * @return
     */
    @RequestMapping("toAddOrUpdateUserPage")
    public String toAddOrUpdateUesrPage(Integer id, HttpServletRequest request) {
        //判断id是否为空，不为空表示更新操作，查询用户对象
        if (id != null) {
            //通过id查询用户对象
            User user = userService.selectByPrimaryKey(id);
            //将数据设置到请求域中
            request.setAttribute("userInfo", user);
        }
        return "user/add_update";
    }

    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateUser(User user) {
        userService.updateUser(user);
        return success("用户更新成功");
    }

    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteUser(Integer[] ids) {
        userService.deleteByIds(ids);
        return success("用户删除成功！");
    }


}
