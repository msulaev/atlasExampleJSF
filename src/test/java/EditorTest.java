import org.junit.jupiter.api.Test;


class EditorTest extends BaseTest {

    @Test
    void shouldCanClickSimpleTool() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf"); //TODO make URL from config
        editorStep.clickSimpleToolToolbarElement("Check");
    }

    @Test
    void shouldCanOpenConstructor() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf"); //TODO make URL from config
        editorStep.openConstructor();
        constructorStep.clickSaveBtn();
    }

    @Test
    void addFieldToGrid() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf"); //TODO make URL from config
        editorStep.openConstructor();
        int[][] grid = constructorStep.createGrid(10);
        constructorStep.addField("Number", "Number1", grid);
        constructorStep.addField("Text", "Text1", grid);
        constructorStep.clickSaveBtn();
        editorStep.enterTextToActiveField("123");
    }

    @Test
    void changePageScale() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf"); //TODO make URL from config
        editorStep.goToLastDocumentPage();
        editorStep.setPercentPageScale("75");
    }

}
