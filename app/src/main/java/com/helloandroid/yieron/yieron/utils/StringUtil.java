package com.helloandroid.yieron.yieron.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wudebin on 2015/4/13.
 */
public class StringUtil {

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[0-9])|(18[0-9])|(14[0-9])|(17[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public static boolean isQQ(String qq) {
        String str = "^[1-9]\\d{4,10}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(qq);

        return m.matches();
    }

    public static boolean isPwdMatcher(String password) {

        String regEx = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isAccountMatcher(String account) {

        String regEx = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }

    public static boolean isPassword(String password) {
        if (6 <= password.length() && password.length() <= 16) {
            return true;
        }
        return false;
    }

    public static boolean isUsername(String username) {
        if (6 <= username.length() && username.length() <= 20) {
            return true;
        }
        return false;
    }

    public static boolean isCode(String code) {
        if (code.length() == 6) {
            return true;
        }
        return false;
    }

    public static boolean isClassInfoCode(String code) {
        if (code.length() == 6) {
            String regEx = "^[a-zA-Z]+$";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(code);
            return matcher.matches();
        }
        return false;
    }

    /**
     * 时间戳转换成年月日
     * @param timestap
     * @return
     */
    public static String getStrTime(String timestap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(timestap) * 1000));
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static boolean isInteger(String str) {
        boolean result;
        try {
            int temp = Integer.valueOf(str);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    public static String createRandomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public static SpannableStringBuilder getColorfulString(String content, String colorString, Context context) {
        int start = content.indexOf(colorString);
        int end = start + colorString.length();
        SpannableStringBuilder style = new SpannableStringBuilder(content);
        style.setSpan(new ForegroundColorSpan(TintDrawableUtils.getPrimaryColor(context)), start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    /**
     * To judge whether an object is empty
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {

        if (obj == null)
            return true;

        if (obj instanceof String) {
            String str = (String) obj;
            if ("".equals(str))
                return true;
            if ("null".equals(str))
                return true;
            if ("''".equals(str))
                return true;
        }
        if (obj instanceof Collection) {
            Collection c = (Collection) obj;
            if (c.isEmpty())
                return true;
        }

        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.isEmpty())
                return true;
        }

        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) <= 0)
                return true;
        }

        return false;
    }

    public static String stringForTime(int timeMs) {
        StringBuilder mFormatBuilder;
        Formatter mFormatter;
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return "00:" + mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    /**
     * 只允许：字母，数字，中文，下划线
     * 不能以下划线作为开头和结尾
     */
    public static boolean isNotEmg(CharSequence text) {
        String regEx = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
        Pattern p = Pattern
                .compile(regEx);
        Matcher m = p.matcher(text);
        return m.matches();
    }
}
