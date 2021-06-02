package command;

import game.character.HeroType;

public class DeserializeHeroTable implements HeroTableOperation {
    private HeroTable heroTable;

    public DeserializeHeroTable(HeroTable heroTable) {
        this.heroTable = heroTable;
    }


    @Override
    public void execute() {
        heroTable.deserialize();
    }
}
