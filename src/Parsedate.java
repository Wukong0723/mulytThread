import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");

public class Parsedate implements Runnable {
    static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();
    private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int i = 0;

    public Parsedate(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            if(t1.get() == null){
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date t = t1.get().parse("2021-07-29 00:00:"+i%60);
            System.out.println(i+":"+t);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 0;i<1000;i++){
            es.execute(new Parsedate(i));
        }
    }
}
