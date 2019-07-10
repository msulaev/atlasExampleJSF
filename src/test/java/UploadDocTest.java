import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static matchers.ExistsMatcher.isExists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

class UploadDocTest extends BaseTest {

    @BeforeEach
    void setUp() {
        onSite().open(cfg.mainUrl());
        baseStep.uploadFile("test.pdf");
    }

    @Test
    void shouldCanUploadAndSaveDoc() {
        editorStep.onEditorPage().loader().waitUntil(not(isExists()), 15);
        editorStep.onEditorPage().doneBtn().click();
        assertThat(editorStep.onEditorPage().modalChoice(), isExists());
    }
}
