import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

//    @ParameterizedTest
//    @ValueSource(strings = {"test1", "test2", "test3"})
    @Test
    void checkSimpleTool() throws  InterruptedException{
        onSite().open(cfg.mainUrl());
        baseStep.uploadFile("test.pdf");
        editorStep.waitForDocumentOpen();
        int[][] grid = constructorStep.createGrid(10);
        editorStep.addSimpleTool("Cross", "cross1", grid);
        editorStep.selectColorOnToolbar("Red");
        editorStep.addSimpleTool("Check", "cross1", grid);
        Thread.sleep(3000);

    }

}
