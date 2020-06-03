package com.xuchen.gradle.core.mysql.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author xuchen
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6,max = 20,message = "名称长度必须为6-20位")
    private String nickName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 20,message = "密码长度必须为6-20位")
    private String password;

    private LocalDateTime createTime;
}
