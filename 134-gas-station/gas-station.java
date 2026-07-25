class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];
            
            // If the tank drops below zero, station 'i' cannot be reached from startStation
            if (currentTank < 0) {
                // Local Disqualification: Move the start past this failure point
                startStation = i + 1;
                // Reset the local tank for the new starting point candidate
                currentTank = 0;
            }
        }
        
        // Global Sufficiency Check
        if (totalGas < totalCost) {
            return -1;
        }
        
        return startStation;
    }
}