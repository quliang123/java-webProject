package controller11validator;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

/**
 * Created by 123 on 2017/08/30.
 */

public class UserInfo {
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3,max = 6,message = "姓名长度应在{min}-{max}")
    private String name;

    @NotNull(message = "成绩最大值为100")
    @Min(value = 0, message = "成绩不能小于{value}")
    @Max(value = 100,message = "成绩不能大于{value}")
    private Integer score;

    @NotEmpty(message = "手机号码不允许为空")
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "手机号码格式不正确")
    private String phone;
}
