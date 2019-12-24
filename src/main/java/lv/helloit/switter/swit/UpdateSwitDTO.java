package lv.helloit.switter.swit;

import javax.validation.constraints.NotBlank;

public class UpdateSwitDTO {
    private Long id;
    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
