package com.pj.clientserv.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Projectinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String projectid;

    private String uid;

    private String projectname;

    private String province;

    private String city;

    private String buildno;

    private String buildnum;

    private String buildsquare;

    private String structuretype;

    private String company;

    private String designer;


}
