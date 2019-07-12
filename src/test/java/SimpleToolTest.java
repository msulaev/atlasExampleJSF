import com.pdffiller.utils.MyCustomExt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import step.EditorStep;

import static matchers.CssAttributeMatcher.assertThatCssAttribute;
import static org.hamcrest.core.Is.is;

@ExtendWith( MyCustomExt.class)
public class SimpleToolTest extends BaseTest{

    @BeforeEach
    void setUp() {
        onSite().open(cfg.mainUrl());
        baseStep.uploadFile("test.pdf");
        editorStep.waitForDocumentOpen();
    }

    @Test
    void shouldCanChangeSimpleToolColor() throws  InterruptedException{
        int[][] grid = constructorStep.createGrid(10);
        editorStep.addSimpleTool("Cross", "cross1", grid);
        editorStep.setColorOnToolbar(EditorStep.Color.Red.getCode());
        assertThatCssAttribute(editorStep.getElementColor("Cross"), is("Red"));
    }

}


