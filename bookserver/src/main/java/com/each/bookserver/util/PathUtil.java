package com.each.bookserver.util;

/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.util
 * @Description: 将通配符表达式转换为正则表达式
 * @Author: zhangxu
 * @CreateDate: 2019/4/13 16:52
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/13 16:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class PathUtil {
    /**
     * 将通配符表达式转换为正则表达式
     * @param path
     * @return
     */
    public static String getRegPath(String path) {
        char[] chars = path.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        boolean preX = false;
        for(int i=0;i<len;i++){
            if (chars[i] == '*'){//遇到*字符
                if (preX){//如果是第二次遇到*，则将**替换成.*
                    sb.append(".*");
                    preX = false;
                }else if(i+1 == len){//如果是遇到单星，且单星是最后一个字符，则直接将*转成[^/]*
                    sb.append("[^/]*");
                }else{//否则单星后面还有字符，则不做任何动作，下一把再做动作
                    preX = true;
                    continue;
                }
            }else{//遇到非*字符
                if (preX){//如果上一把是*，则先把上一把的*对应的[^/]*添进来
                    sb.append("[^/]*");
                    preX = false;
                }
                if (chars[i] == '?'){//接着判断当前字符是不是?，是的话替换成.
                    sb.append('.');
                }else{//不是?的话，则就是普通字符，直接添进来
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }
}

