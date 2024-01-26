package hu.modeldriven.astah.core;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.ITransactionManager;

public class AstahTransaction {

    public void execute(Runnable command) throws Exception {

        ITransactionManager transactionManager = AstahAPI.getAstahAPI().getProjectAccessor().getTransactionManager();

        try {
            transactionManager.beginTransaction();

            command.run();

            transactionManager.endTransaction();

        } catch (Exception e) {
            transactionManager.abortTransaction();
        }
    }

}
