package testTasks.uniqIpAddress;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitSetUniqueIpCounter implements UniqueIpCounter {

    private final Logger logger = Logger.getLogger("BitSetUniqueIpCounter");

    /*
    To count unique IP's use a bit array, where each bit is set in accordance with one IP address.
    In Java, there is no unsigned int and maximum BitSet size is integer.MAX_VALUE therefore we use two arrays.
     */
    private final BitSet bitSetLow = new BitSet(Integer.MAX_VALUE); // 0 - 2_147_483_647
    private final BitSet bitSetHi = new BitSet(Integer.MAX_VALUE); // 2_147_483_648 - 4_294_967_295
    private long counter = 0;

    private void registerLongValue(long longValue) {
        int intValue = (int) longValue;
        BitSet workingSet = bitSetLow;
        if (longValue > Integer.MAX_VALUE) {
            intValue = (int) (longValue - Integer.MAX_VALUE);
            workingSet = bitSetHi;
        }

        if (!workingSet.get(intValue)) {
            counter++;
            workingSet.set(intValue);
        }
    }

    @Override
    public long countUniqueIp(String fileName) {
        logger.log(Level.INFO, "Reading file: " + fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            long linesProcessed = 0;
            String line;
            // If already counted 2 ^ 32 unique addresses, then to the end of the file there will be only duplicates
            while ((line = in.readLine()) != null && counter <= NUMBER_OF_IP_ADDRESSES) {
                registerLongValue(UniqueIpCounter.toLongValue(line));
                linesProcessed++;
            }
            logger.log(Level.INFO, "Total lines processed: " + linesProcessed);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File '" + fileName + "' not found", e);
            counter = -1;
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException occurs", e);
            counter = -1;
        }
        return counter;
    }
}
