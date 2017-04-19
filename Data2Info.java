import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/19.
 */
public class Data2Info implements Serializable{
    String id;
    String name;
    String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
