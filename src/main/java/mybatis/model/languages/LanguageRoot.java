package mybatis.model.languages;

public class LanguageRoot {

    LanguageData data;

    public LanguageRoot() {
    }

    public LanguageRoot(LanguageData data) {
        this.data = data;
    }

    public LanguageData getData() {
        return data;
    }

    public void setData(LanguageData data) {
        this.data = data;
    }
}
