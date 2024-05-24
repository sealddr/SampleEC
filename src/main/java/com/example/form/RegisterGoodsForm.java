package com.example.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterGoodsForm {
    @NotBlank(groups = ValidGroup1.class)
    private String goodsName;

    @NotBlank(groups = ValidGroup1.class)
    private String goodsDescription;

    private int goodsCategoryId;

    @NotBlank(groups = ValidGroup1.class)
    @Digits(integer = 9, fraction = 0, groups = ValidGroup2.class)
    private int price;

    @NotBlank(groups = ValidGroup1.class)
    @Pattern(regexp = "^[a-z]+(\\/[a-z]+)*$", groups = ValidGroup2.class)
    private String serviceURL;
}