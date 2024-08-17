package org.aston.reader_file.parse;
import org.aston.model.Bus;

public class BusParser implements RecordParser<Bus> {
    @Override
    public String getPrefix() {
        return "Bus";
    }

    @Override
    public Bus parse(String line) {
        line =	line.replace("Bus = ","");
        String[] parts = line.split(",");
        return new Bus.Builder()
                .setNumber(parts[0].trim())
                .setModel(parts[1].trim())
                .setMileage(Integer.parseInt(parts[2].trim()))
                .build();
    }
}