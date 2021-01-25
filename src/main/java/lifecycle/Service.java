package lifecycle;

import org.springframework.stereotype.Component;

@Component
public class Service {
    private int count = 5;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Service{" +
                "count=" + count +
                '}';
    }
}
