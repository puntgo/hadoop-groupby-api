import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Country implements  WritableComparable<Country>{
	
	Text country;
    Text state;
    public Country(Text country, Text state) {
        this.country = country;
        this.state = state;
    }
    public Country() {
        this.country = new Text();
        this.state = new Text();
    }
public void write(DataOutput out) throws IOException {
        this.country.write(out);
        this.state.write(out);
    }
public void readFields(DataInput in) throws IOException {
        this.country.readFields(in);
        this.state.readFields(in);
    }
public int compareTo(Country pop) {
        if (pop == null)
            return 0;
        int intcnt = country.compareTo(pop.country);
        if (intcnt != 0) {
            return intcnt;
        } else {
            return state.compareTo(pop.state);

        }
    }
@Override
    public String toString() {
return country.toString() + "" + state.toString();
    }

	
	

}
