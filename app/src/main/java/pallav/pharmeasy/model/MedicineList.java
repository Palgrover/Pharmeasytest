package pallav.pharmeasy.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by pallavgrover on 4/19/16.
 */
public class MedicineList extends SugarRecord {

    private String message;
    private List<Medicine> result;
    private int status;
    private String op;
    private String errors;
    private String searchTerm;
    private int totalRecordCount;
    private boolean hasMore;
    private String TEMP_USER_ID;

    public MedicineList(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Medicine> getResult() {
        return result;
    }

    public void setResult(List<Medicine> result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getTEMP_USER_ID() {
        return TEMP_USER_ID;
    }

    public void setTEMP_USER_ID(String TEMP_USER_ID) {
        this.TEMP_USER_ID = TEMP_USER_ID;
    }
}
