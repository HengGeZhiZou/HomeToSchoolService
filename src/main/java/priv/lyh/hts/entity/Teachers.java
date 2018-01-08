package priv.lyh.hts.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teachers {
    private String teacNum;
    private String teacName;
    private String teacClass;
    private String teacPwd;

    @Id
    @Column(name = "teac_num")
    public String getTeacNum() {
        return teacNum;
    }

    public void setTeacNum(String teacNum) {
        this.teacNum = teacNum;
    }

    @Basic
    @Column(name = "teac_name")
    public String getTeacName() {
        return teacName;
    }

    public void setTeacName(String teacName) {
        this.teacName = teacName;
    }

    @Basic
    @Column(name = "teac_class")
    public String getTeacClass() {
        return teacClass;
    }

    public void setTeacClass(String teacClass) {
        this.teacClass = teacClass;
    }

    @Basic
    @Column(name = "teac_pwd")
    public String getTeacPwd() {
        return teacPwd;
    }

    public void setTeacPwd(String teacPwd) {
        this.teacPwd = teacPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teachers teachers = (Teachers) o;

        if (teacNum != null ? !teacNum.equals(teachers.teacNum) : teachers.teacNum != null) return false;
        if (teacName != null ? !teacName.equals(teachers.teacName) : teachers.teacName != null) return false;
        if (teacClass != null ? !teacClass.equals(teachers.teacClass) : teachers.teacClass != null) return false;
        if (teacPwd != null ? !teacPwd.equals(teachers.teacPwd) : teachers.teacPwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacNum != null ? teacNum.hashCode() : 0;
        result = 31 * result + (teacName != null ? teacName.hashCode() : 0);
        result = 31 * result + (teacClass != null ? teacClass.hashCode() : 0);
        result = 31 * result + (teacPwd != null ? teacPwd.hashCode() : 0);
        return result;
    }
}
