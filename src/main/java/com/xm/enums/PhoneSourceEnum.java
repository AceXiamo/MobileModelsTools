package com.xm.enums;

import lombok.Getter;


/**
 * @Author: AceXiamo
 * @ClassName: PhoneSourceUrlEnum
 * @Date: 2022/10/18  16:13
 */
@Getter
public enum PhoneSourceEnum {

    XIAMO("xiaomi", getUrl("xiaomi.md")),
    HUAWEI("huawei", getUrl("huawei_cn.md")),
    HONOR("honor", getUrl("honor_cn.md")),
    GOOGLE("google", getUrl("google_en.md")),
    LENOVO("lenovo", getUrl("lenovo.md")),
    LETV("letv", getUrl("letv.md")),
    MEIZU("meizu", getUrl("meizu.md")),
    MOTOROLA("motorola", getUrl("motorola.md")),
    NOKIA("nokia", getUrl("nokia.md")),
    NUBIA("nubia", getUrl("nubia.md")),
    ONEPLUS("oneplus", getUrl("oneplus.md")),
    OPPO("oppo", getUrl("oppo_cn.md")),
    REALME("realme", getUrl("realme_cn.md")),
    SAMSUNG("samsung", getUrl("samsung_cn.md")),
    SONY("sony", getUrl("sony_cn.md")),
    VIVO("vivo", getUrl("vivo.md")),
    ZHIXUAN("zhixuan", getUrl("zhixuan.md")),
    ZTE("zte", getUrl("zte.md")),
    ;

    private final static String URL_PREFIX = "https://raw.githubusercontent.com/KHwang9883/MobileModels/master/brands/";
//    private final static String URL_PREFIX = "https://cdn.jsdelivr.net/gh/KHwang9883/MobileModels/brands/";

    private final String brand;
    private final String url;

    PhoneSourceEnum(String brand, String url) {
        this.brand = brand;
        this.url = url;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public static String getUrl(String suffix) {
        return URL_PREFIX + suffix;
    }

}
