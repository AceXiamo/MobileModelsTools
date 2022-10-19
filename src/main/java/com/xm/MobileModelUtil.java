package com.xm;

import cn.hutool.http.HttpUtil;
import com.xm.enums.PhoneSourceEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: AceXiamo
 * @ClassName: MobileToolsUtil
 * @Date: 2022/10/18  14:45
 */
public class MobileModelUtil {

    /**
     * The constant result.
     */
    public static String result = "";

    /**
     * Load md file.
     */
    public static void loadMdFile(PhoneSourceEnum phoneSourceUrlEnum) {
        result = HttpUtil.get(phoneSourceUrlEnum.getUrl());
    }

    /**
     * Device name string.
     *
     * @param model the model
     * @return the string
     */
    public static String deviceName(String model) {
        String res = "";
        String regex = "(?i)" + model + "`:(.*)\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            res = matcher.group(1);
            // 去首尾空格
            res = removeSpace(res);

            // 去除尾部版本，全网通版/移动定制版/移动 4G+ 版...
            regex = "\\s[\u4e00-\u9fa5](.*)([\u4e00-\u9fa5]|\\))$";
            res = res.replaceAll(regex, "");

            // 去除网络版本，4G/5G
            regex = "[0-9]G|g$";
            res = res.replaceAll(regex, "");

            // 去首尾空格
            res = removeSpace(res);
        }
        return res;
    }

    /**
     * Remove space string.
     *
     * @param res the res
     * @return the string
     */
    public static String removeSpace(String res) {
        String regex = "^\\s";
        res = res.replaceAll(regex, "");
        regex = "\\s$";
        res = res.replaceAll(regex, "");
        return res;
    }

    public static void main(String[] args) {
        loadMdFile(PhoneSourceEnum.XIAMO);
        String name = deviceName("M2102K1C");
        System.out.println(name);
    }

}
