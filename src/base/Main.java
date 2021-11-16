package base;
import controllers.Stopwatch;
import frames.MyFrame;
import model.MyTimer;

public class Main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame(0,0,0);
        MyTimer timer = new MyTimer(frame);
        Stopwatch stopwatch = new Stopwatch(frame, timer);
    }
}
