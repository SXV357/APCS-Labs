public class ExperimentalFarm {
    private Plot[][] farmPlots;

    public ExperimentalFarm(Plot[][] p) {
        farmPlots = p;
    }

    public Plot getHighestYield(String c) {
        int max = 0;
        Plot end = null;
        for (int i = 0; i < farmPlots.length; i++) {
            for (int j = 0; j < farmPlots[0].length; j++) {
                Plot p = farmPlots[i][j];
                if (p.getCropType().equals(c) && p.getCropYield() > max) {
                    max = p.getCropYield();
                    end = p;
                }
            }
        }
        return end;
    }

    public boolean sameCrop(int col) {
        for (int r = 0; r < farmPlots[0].length; r++) {
            if (!farmPlots[r][col].getCropType().equals(farmPlots[0][col].getCropType())) {
                return false;
            }
        }
        return true;
    }
}
