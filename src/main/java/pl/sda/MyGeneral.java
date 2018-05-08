package pl.sda;

import java.util.*;

public class MyGeneral {
    private List<String> headers;
    private List<Map<String,String>> datesets;

    public MyGeneral() {
        this.datesets = new ArrayList<>();
    }

    public void add(Map<String,String> date){
        datesets.add(date);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<Map<String, String>> getDatesets() {
        return datesets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyGeneral myGeneral = (MyGeneral) o;


        TreeSet setOrg =new TreeSet(this.headers);
        TreeSet setO =new TreeSet(((MyGeneral) o).headers);

        if(!setOrg.equals(setO)){
            return false;
        }




        for (int i = 0; i < headers.size(); i++) {
//            if(!(headers.get(i).equals(myGeneral.headers.get(i)))){
//                System.out.println("expect: "+headers.get(i)+" : "+ "get: " + myGeneral.headers.get(i));
//                return false;
//            }
            for (int j = 0; j < datesets.size(); j++) {
                if(!(Objects.equals(datesets.get(j).get(headers.get(i)),myGeneral.datesets.get(j).get(headers.get(i))))){
                    System.out.println("expect: "+datesets.get(j).get(headers.get(i))+" : "+ "get: " + myGeneral.datesets.get(j).get(headers.get(i)));
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(headers, datesets);
    }
}
