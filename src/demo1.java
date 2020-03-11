import JSonEvalUtils.JSonEval;

/**
 * 作者：sandyzhang
 * 时间：2020/3/11
 */
public class demo1 {
    public static void main(String[] args) {
        String json="{\"age\":66,\"s\":\"sb\"}";
        String json2="[{\"money\":-6.0,\"time\":1583906400000,\"tips\":\"\",\"waysImage\":\"微信\",\"type\":\"娱乐项目\"},{\"money\":-36.0,\"time\":1583456400000,\"tips\":\"\",\"waysImage\":\"微信\",\"type\":\"娱乐项目\"},{\"money\":-6.0,\"time\":1582905600000,\"tips\":\"\",\"waysImage\":\"支付宝\",\"type\":\"娱乐项目\"},{\"money\":-0.6,\"time\":1582452000000,\"tips\":\"\",\"waysImage\":\"支付宝\",\"type\":\"饮食\"},{\"money\":-6.0,\"time\":1582452000000,\"tips\":\"\",\"waysImage\":\"支付宝\",\"type\":\"饮食\"},{\"money\":-6.0,\"time\":1582452000000,\"tips\":\"\",\"waysImage\":\"支付宝\",\"type\":\"饮食\"},{\"money\":-6.0,\"time\":1582444800000,\"tips\":\"\",\"waysImage\":\"支付宝\",\"type\":\"娱乐项目\"},{\"money\":-3.0,\"time\":1582444800000,\"tips\":\"\",\"waysImage\":\"微信\",\"type\":\"饮食\"},{\"money\":-6.0,\"time\":1577865600000,\"tips\":\"\",\"waysImage\":\"支付宝\",\"type\":\"饮食\"}]";
        String json3="[325.3425,32453.54232345432554,3245.3452]";

        //测试一些用法，暂时没写注释
        //最外层的空格会被自动删除，但string字段里的空格不会被删除
        try{
            //解析json到bean类
            Test test = JSonEval.getInstance().fromJson(json,Test.class);
            System.out.println(test.getAge()+" "+test.s);
            //解析jsonArray到string数组
            String[] abc=JSonEval.getInstance().fromJson(json2,String[].class);
            System.out.println(abc.length);
            System.out.println(abc[2]);
            //解析jsonArray到double数组
            double[] doubles=JSonEval.getInstance().fromJson(json3,double[].class);
            System.out.println(doubles.length);
            System.out.println(doubles[1]);
            //根据jsonArray的第三项解析为一个bean类
            Test2 test2=JSonEval.getInstance().fromJson(abc[2],Test2.class);
            System.out.println(test2.waysImage);
            //根据bean类解析出一个jsonObjectString
            System.out.println(JSonEval.getInstance().toJson(test2));
            //根据数组解析为jsonArrayString
            int[] ints=new int[]{1,2,3};
            String s1=JSonEval.getInstance().toJson(ints);
            System.out.println(s1);
            //根据jsonArray转成

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
