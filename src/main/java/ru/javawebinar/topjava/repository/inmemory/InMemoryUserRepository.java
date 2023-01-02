package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Integer, User> repository = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);

    @Override
    public User save(User user) {
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
            repository.put(user.getId(), user);
            return user;
        }
        // handle case: update, but not present in storage
        return repository.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository
                .values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }

    @Override
    public List<User> getAll() {
//        Collections.sort((List<User>) repository.values());
//        List<User> users = (List<User>) repository.values();

//        ArrayList<User> users = new ArrayList<User>();
//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getName().compareTo(o2.getName());
//                if(temp ==0)
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        users.sort(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return ;
//            }
//        });
        return repository.values()
                .stream()
                .sorted(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .collect(Collectors.toList());
    }

//    @Override
//    public boolean delete(int id) {
//        log.info("delete {}", id);
//        return true;
//    }

//    @Override
//    public User save(User user) {
//        log.info("save {}", user);
//        return user;
//    }

//    @Override
//    public User get(int id) {
//        log.info("get {}", id);
//        return null;
//    }

//    @Override
//    public List<User> getAll() {
//        log.info("getAll");
//        return Collections.emptyList();
//    }

//    @Override
//    public User getByEmail(String email) {
//        log.info("getByEmail {}", email);
//        return null;
//    }
}
