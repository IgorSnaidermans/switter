package lv.helloit.switter.swit;

import javax.validation.constraints.NotBlank;

public class ChangeSwitDTO {
    @NotBlank
    private String userId;
    @NotBlank
    private String content;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
