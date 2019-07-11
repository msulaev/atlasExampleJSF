import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static matchers.CssAttributeMatcher.assertThatCssAttribute;
import static org.hamcrest.core.Is.is;

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
        editorStep.selectColorOnToolbar("Red");
        assertThatCssAttribute(editorStep.getElementColor("Cross"), is("Red"));
    }

}


