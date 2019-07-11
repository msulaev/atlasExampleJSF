import org.junit.jupiter.api.Test;

import static matchers.CssAttributeMatcher.cssAttribute;

class EditorTest extends BaseTest {

    @Test
    void shouldCanClickSimpleTool() throws InterruptedException {
        onSite().editor().open(cfg.baseUrl()); //TODO make URL from config
        editorStep.clickSimpleToolToolbarElement("Check");
    }

    @Test
    void shouldCanOpenConstructor() throws InterruptedException {
        onSite().editor().open(cfg.baseUrl()); //TODO make URL from config
        editorStep.openConstructor();
        constructorStep.clickSaveBtn();
    }

    @Test
    void addFieldToGrid() throws InterruptedException {
        onSite().editor().open(cfg.baseUrl()); //TODO make URL from config
        editorStep.openConstructor();
        int[][] grid = constructorStep.createGrid(10);
        constructorStep.addField("Number", "Number1", grid);
        constructorStep.addField("Text", "Text1", grid);
        constructorStep.clickSaveBtn();
        editorStep.enterTextToActiveField("123");
    }

    @Test
    void changePageScale() throws InterruptedException {
        onSite().editor().open(cfg.baseUrl()); //TODO make URL from config
        editorStep.goToLastDocumentPage();
        editorStep.setPercentPageScale("75");
    }

    @Test
    void uploadDoc() throws InterruptedException {
        onSite().open(cfg.mainUrl());
        baseStep.uploadFile("test.pdf");
        Thread.sleep(4000);
    }

    @Test
    void changeSimpleToolColor() throws  InterruptedException{
        onSite().open(cfg.mainUrl());
        baseStep.uploadFile("test.pdf");
        editorStep.waitForDocumentOpen();
        int[][] grid = constructorStep.createGrid(10);
        editorStep.addSimpleTool("Cross", "cross1", grid);
        editorStep.selectColorOnToolbar("Red");
        cssAttribute(editorStep.getElementColor("checkmark"), "Red");
    }

}
