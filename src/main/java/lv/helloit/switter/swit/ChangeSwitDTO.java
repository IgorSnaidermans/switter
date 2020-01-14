package lv.helloit.switter.swit;

import javax.validation.constraints.NotBlank;

public class ChangeSwitDTO {
    @NotBlank
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
