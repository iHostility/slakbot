package com.slackbot.slakbot.dao;

import com.slackbot.slakbot.actions.NewAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository("postgres")
public class ActionDataAccessService implements ActionDAO {

    private final JdbcTemplate jdbcTemplate;
    public Timestamp timestamp;

    @Autowired
    public ActionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //BASE CASES
    @Override
    public int addSessionNow(NewAction action) {
        final String sql = "INSERT INTO sessions (username, workstart) VALUES (?, CURRENT_TIMESTAMP)";
        jdbcTemplate.update(sql, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int addSessionSelect(NewAction action, LocalDateTime time) {
        timestamp = Timestamp.valueOf(time);
        final String sql = "INSERT INTO sessions (username, workstart) VALUES (?, ?)";
        jdbcTemplate.update(sql, action.getUser().getUsername(), timestamp);
        return 0;
    }

    @Override
    public int closeSessionNow(NewAction action) {
        final String sql = "UPDATE sessions SET workend = CURRENT_TIMESTAMP WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int closeSessionSelect(NewAction action, LocalDateTime time) {
        timestamp = Timestamp.valueOf(time);
        final String sql = "UPDATE sessions SET workend = ? WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, timestamp, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int addLunchNow(NewAction action) {
        final String sql = "UPDATE sessions SET lunchstart = CURRENT_TIMESTAMP WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int addLunchSelect(NewAction action, LocalDateTime time) {
        timestamp = Timestamp.valueOf(time);
        final String sql = "UPDATE sessions SET lunchstart = ? WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, timestamp, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int endLunchNow(NewAction action) {
        final String sql = "UPDATE sessions SET lunchend = CURRENT_TIMESTAMP WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int endLunchSelect(NewAction action, LocalDateTime time) {
        timestamp = Timestamp.valueOf(time);
        final String sql = "UPDATE sessions SET lunchend = ? WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, timestamp, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int addAwayNow(NewAction action, String reason) {
        final String sql = "UPDATE sessions SET awaystart = CURRENT_TIMESTAMP, reason = ? WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, reason, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int addAwaySelect(NewAction action, LocalDateTime time, String reason) {
        timestamp = Timestamp.valueOf(time);
        final String sql = "UPDATE sessions SET awaystart = ?, reason = ? WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, timestamp, reason, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int awayBackNow(NewAction action) {
        final String sql = "UPDATE sessions SET awayend = CURRENT_TIMESTAMP WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, action.getUser().getUsername());
        return 0;
    }

    @Override
    public int awayBackSelect(NewAction action, LocalDateTime time) {
        timestamp = Timestamp.valueOf(time);
        final String sql = "UPDATE sessions SET awayend = ? WHERE username = ? AND date = CURRENT_DATE";
        jdbcTemplate.update(sql, timestamp, action.getUser().getUsername());
        return 0;
    }

    //TODO REPORTS

//    @Override
//    public List<Event> selectAllEvent() {
//        final String sql = "SELECT id, token, challenge, type FROM events";
//        return jdbcTemplate.query(sql, (resultSet, i) -> {
//            UUID id = UUID.fromString((resultSet.getString("id")));
//            String token = resultSet.getString("token");
//            String challenge = resultSet.getString("challenge");
//            String type = resultSet.getString("type");
//            return e() {
//            }
//            ;
//        });
//    }
//
//    @Override
//    public Optional<Event> selectEventByID(UUID id) {
//        final String sql = "SELECT id, token, challenge, type FROM events WHERE id = ?";
//        Event event = jdbcTemplate.queryForObject(
//                sql,
//                new Object[]{id},
//                (resultSet, i) -> {
//                    UUID eventId = UUID.fromString(resultSet.getString("id"));
//                    String token = resultSet.getString("token");
//                    String challenge = resultSet.getString("challenge");
//                    String type = resultSet.getString("type");
//                    return new Event(eventId, token, challenge, type);
//                });
//        return Optional.ofNullable(event);
//    }
//
}
