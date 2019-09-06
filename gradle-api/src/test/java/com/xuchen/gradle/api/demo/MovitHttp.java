package com.xuchen.gradle.api.demo;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Edwin
 * @date 2019/8/27
 */
public class MovitHttp {
    public static void main(String[] args) {
        HttpResponse response;
        long begin = System.currentTimeMillis();
        //post
//        String url = "http://localhost:8000/process/circulation/agreeTask";
//        String url = "http://localhost:8000/process/circulation/startProcess";
        String url = "http://localhost:8000/process/circulation/historyAndForecast";
//        String url = "http://localhost:8000/process/circulation/forecastByTaskId";
//        String url = "http://localhost:8000/process/circulation/forecast";
//        String url = "http://localhost:8000/process/intervene/jump";
//        String url = "http://localhost:8000/process/intervene/adminAgreeProcess";
        String jsonParam = "{\"proInsId\":\"89045349884371657\",\"updateTodoCenter\":true,\"taskVariables\":{\"phase\":\"JD-10\",\"approveResult\":\"Y\"},\"submitFlag\":0,\"needRestart\":true}\n";
//        String jsonParam = "{\"proInsId\":\"87123190318931969\",\"nextNodeRoleMap\":{\"33600\":[{\"roleCode\":\"财务指派\",\"roleName\":\"财务指派\",\"roleType\":\"0\"}],\"33400\":[{\"roleCode\":\"运营指派\",\"roleName\":\"运营指派\",\"roleType\":\"0\"}],\"33510\":[{\"roleCode\":\"成本：成本测算\",\"roleName\":\"成本：成本测算\",\"roleType\":\"0\"}],\"33500\":[{\"roleCode\":\"成本指派\",\"roleName\":\"成本指派\",\"roleType\":\"0\"}],\"33610\":[{\"roleCode\":\"财务：审核税费及财务成本\",\"roleName\":\"财务：审核税费及财务成本\",\"roleType\":\"0\"}],\"33200\":[{\"roleCode\":\"旅游研究院指派\",\"roleName\":\"旅游研究院指派\",\"roleType\":\"0\"}],\"33310\":[{\"roleCode\":\"营销：销售计划\",\"roleName\":\"营销：销售计划\",\"roleType\":\"0\"}],\"33300\":[{\"roleCode\":\"营销指派\",\"roleName\":\"营销指派\",\"roleType\":\"0\"}],\"33410\":[{\"roleCode\":\"运营：开发分期及节点\",\"roleName\":\"运营：开发分期及节点\",\"roleType\":\"0\"}],\"33110\":[{\"roleCode\":\"营销：强排建议及价格建议\",\"roleName\":\"营销：强排建议及价格建议\",\"roleType\":\"0\"}],\"33100\":[{\"roleCode\":\"营销指派\",\"roleName\":\"营销指派\",\"roleType\":\"0\"}],\"33210\":[{\"roleCode\":\"旅游研究院\",\"roleName\":\"旅游研究院\",\"roleType\":\"0\"}]},\"taskVariables\":{\"approveResult\":\"Y\",\"skipKey\":\"2\"},\"proUserName\":\"admin\",\"businessId\":\"myBusiId\",\"proNickName\":\"admin\",\"proKey\":\"LIMSGDKEY\",\"appCode\":\"unitTest\"}";
//        String jsonParam = "{\"taskVariables\":{\"days\":\"18\"},\"proUserName\":\"admin\",\"businessId\":\"myBusiId\",\"proNickName\":\"admin\",\"proKey\":\"LeaveKey\",\"appCode\":\"unitTest\"}";
//        String jsonParam = "{\"updateTodoCenter\":true,\"taskVariables\":{\"phase\":\"JD-40\",\"approveResult\":\"Y\"},\"submitFlag\":0,\"taskId\":\"86118460142690322\",\"needRestart\":true}\n";
//        String jsonParam = "{\"userProAttaches\":[],\"comment\":\"111\",\"proUserName\":\"huangyanxia\",\"proNickName\":\"黄燕霞\",\"appCode\":\"de\",\"proKey\":\"projectflow01\",\"proInsName\":\"黄燕霞_13123_数据填报\",\"taskVariables\":{\"phase\":\"JD-10\",\"approveResult\":\"Y\",\"modelCode\":\"XY05\",\"roleCode\":\"XMGS_000015,ROLE_XMGS_YYWH\"},\"extendParameter\":\"{\\\"modelCode\\\":\\\"XY05\\\",\\\"projectVersionId\\\":\\\"A4534jafNE8ajar7MI-Ak3\\\",\\\"type\\\":\\\"0\\\",\\\"projectId\\\":\\\"ASOaKeCF9HwLOrJiNVO03e\\\"}\",\"departmentCode\":\"000015\",\"departmentName\":\"合肥汇博房地产开发有限公司\"}";
        response = post(url, jsonParam);

        //get
//        String url = "http://localhost:8000/process/actb/getApprovedNodes";
//        response = get(url, new HashMap<String, Object>() {{
//            put("proInsId", "86396224880025601");
//        }});
        System.out.println(JSONUtil.toJsonPrettyStr(response.body()));
        long end = System.currentTimeMillis();
        System.out.println((end - begin) / 1000 + "." + (end - begin) % 1000 + " s");
    }

    private static HttpResponse get(String url, Map<String, Object> paramMap) {
        return HttpUtil
                .createGet(url)
                .header("Authorization", getToken())
                .form(paramMap)
                .execute();
    }

    private static HttpResponse post(String url, String jsonParam) {
        return HttpUtil
                .createPost(url)
                .header("Authorization", getToken())
                .body(jsonParam)
                .execute();
    }

    private static String getToken() {
        HttpResponse login = HttpUtil.createPost("http://172.19.50.42:11093/login")
                .form("username", "admin")
                .form("password", "admin")
                .execute();
        String token = String.valueOf(JSONUtil.parseObj(login.body()).get("data"));
        return token;
    }
}
