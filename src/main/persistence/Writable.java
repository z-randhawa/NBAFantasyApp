package persistence;

import org.json.JSONObject;

// Interface framework from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
