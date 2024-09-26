import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;
import java.sql.Timestamp; 

public class TestTime {

	public static void main(String[] args) {
		java.util.Date time = new java.util.Date((long)1706250460*1000);
		 TimeZone timeZone = TimeZone.getTimeZone("UTC");
		// time.setTimeZone(timeZone);
		System.out.println(time);
		Instant instant = Instant.ofEpochSecond( 1706250460 );
		java.util.Date  date = Date.from(instant);
		System.out.println(date);
		 Timestamp timeStamp = new Timestamp((long)1706250746 * 1000);
		 System.out.println("sql timestamp..."+timeStamp);
		 long unixTimestamp = 1706250746;

	        // Convert Unix timestamp to ZonedDateTime with UTC time zone
	        instant = Instant.ofEpochSecond(unixTimestamp);
	        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
	        System.out.println(zonedDateTime);

	}
	
}
