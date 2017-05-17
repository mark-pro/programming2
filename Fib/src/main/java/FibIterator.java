import java.math.BigInteger;
import java.util.Iterator;

public class FibIterator implements Iterable<BigInteger> {

    private BigInteger stopNumber;
    public FibIterator(BigInteger stopNumber) { this.stopNumber = stopNumber; }

    @Override
    public Iterator<BigInteger> iterator() {
      return new Iterator<BigInteger>() {
            
            private BigInteger lastNumber = BigInteger.valueOf(Integer.valueOf(0));
            private BigInteger currentNumber = BigInteger.valueOf(Integer.valueOf(1));

            @Override
            public boolean hasNext() {
                return (this.lastNumber.compareTo(stopNumber) == -1 || this.lastNumber.compareTo(stopNumber) == 0) && 
                    this.currentNumber.compareTo(BigInteger.valueOf(Integer.valueOf(0))) == 1;
            }

            @Override
            public BigInteger next() {
                if(stopNumber.compareTo(BigInteger.valueOf(Integer.valueOf(1))) == 0) {
                    this.lastNumber = BigInteger.valueOf(Integer.valueOf(2));
                    return (BigInteger) stopNumber;
                }

                BigInteger temp = this.currentNumber;
                BigInteger lastTemp = this.lastNumber;
                this.currentNumber = this.getNextNumber();
                this.lastNumber = temp;
                return lastTemp;
            }
            
            private BigInteger getNextNumber() {
                return this.lastNumber.add(this.currentNumber);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}