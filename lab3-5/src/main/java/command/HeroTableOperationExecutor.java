package command;

import java.util.ArrayList;
import java.util.List;

public class HeroTableOperationExecutor {
    private final List<HeroTableOperation> heroTableOperationList = new ArrayList<>();

    public void executeOperation(HeroTableOperation heroTableOperation) {
        heroTableOperationList.add(heroTableOperation);
        heroTableOperation.execute();
    }
}
