package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static String password_generator(String str1, String str2 ,ArrayList<Integer> a_list, int pw_len){
        //Creates a random password using two strings and one array list.
        //Chooses a char according to the number from related list.

        if((a_list.size() == 0 || str1.length() == 0 || str2.length() == 0 || pw_len == 0 || a_list.size() < pw_len) ||
                (str1.length() <= pw_len/2 || str2.length() <= pw_len/2 ) )
            return null;

        if (pw_len <= 6)
            return null;

        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < a_list.size() ; i++) {
            if (i == pw_len - 1)
                break;

            if (i%2 == 0){
                stringBuilder.append(str1.charAt(a_list.get(i)%str1.length())); //for i%2 == 0, char comes from str1
            }
            else
                stringBuilder.append(str2.charAt(a_list.get(i)%str2.length())); //for i%2 == 0, char comes from str2
        }

        //arbitrary chars index has determined by number%str.len

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {

            String list = req.queryParams("list");
            java.util.Scanner sc1 = new java.util.Scanner(list);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);


            String str1 = req.queryParams("str1").replaceAll("\\s","");
            String str2 = req.queryParams("str2").replaceAll("\\s","");

            String pw_len = req.queryParams("pw_len").replaceAll("\\s","");
            int pw_length = Integer.parseInt(pw_len);

            String result = App.password_generator(str1, str2 ,inputList, pw_length);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
