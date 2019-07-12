package com.lwb.cloud.dfa.service.dfa;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author liuweibo
 * @date 2019/7/12
 */
public class DfaService {

    private static Map sensitiveWordMap;


    /**
     * 读取敏感词库，将敏感词放入HashMap中，构建一个DFA算法模型：<br>
     * 中 = {
     * isEnd = 0
     * 国 = {<br>
     * isEnd = 1
     * 人 = {isEnd = 0
     * 民 = {isEnd = 1}
     * }
     * 男  = {
     * isEnd = 0
     * 人 = {
     * isEnd = 1
     * }
     * }
     * }
     * }
     * 五 = {
     * isEnd = 0
     * 星 = {
     * isEnd = 0
     * 红 = {
     * isEnd = 0
     * 旗 = {
     * isEnd = 1
     * }
     * }
     * }
     * }
     * @param keyWordSet 敏感词库
     * @author chenming
     * @date 2014年4月20日 下午3:04:20
     * @version 1.0
     */
    private static void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size());     //初始化敏感词容器，减少扩容操作
        String key;
        Map nowMap;
        Map<String, String> newWorMap;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();    //关键字
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);       //转换成char型
                Object wordMap = nowMap.get(keyChar);       //获取

                if (wordMap != null) {        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }
                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
        System.out.println(JSONObject.toJSONString(sensitiveWordMap));
    }

    public static void main(String[] args) {
        Set<String> set = Sets.newHashSet("日本", "日本鬼子", "鬼子", "鬼");
        addSensitiveWordToHashMap(set);
    }
}
