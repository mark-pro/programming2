import java.util.Iterator;

public class FibIterator implements Iterable<Long> {

    private long stopNumber;
    public FibIterator(long stopNumber) { this.stopNumber = stopNumber; }

    @Override
    public Iterator<Long> iterator() {
      return new Iterator<Long>() {
            
            private long lastNumber = 0;
            private long currentNumber = 1;

            @Override
            public boolean hasNext() {
                return this.lastNumber <= stopNumber && this.currentNumber > 0;
            }

            @Override
            public Long next() {
                if(stopNumber == 1) {
                    this.lastNumber = 2;
                    return (long) stopNumber;
                }

                long temp = this.currentNumber;
                long lastTemp = this.lastNumber;
                this.currentNumber = this.getNextNumber();
                this.lastNumber = temp;
                return lastTemp;
            }
            
            private long getNextNumber() {
                return this.lastNumber + this.currentNumber;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}