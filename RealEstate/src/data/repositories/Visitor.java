package data.repositories;
import java.util.ArrayList;
import java.util.List;

public class Visitor implements VisitorRepo {
    private List<data.models.Visitor> visitors = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<data.models.Visitor> findAll() {
        return new ArrayList<>(visitors);
    }

    @Override
    public data.models.Visitor findById(int id) {
        for (data.models.Visitor visitor : visitors) {
            if (visitor.getId() == id) {
                return visitor;
            }
        }
        return null;
    }

    @Override
    public void save(data.models.Visitor visitor) {
        if (visitor.getId() == 0) {
            visitor.setId(nextId++);
            visitors.add(visitor);
        } else {
            data.models.Visitor existing = findById(visitor.getId());
            if (existing != null) {
                int index = visitors.indexOf(existing);
                visitors.set(index, visitor);
            } else {
                visitors.add(visitor);
            }
        }
    }

    @Override
    public void delete(data.models.Visitor visitor) {
        visitors.remove(visitor);
    }

    @Override
    public void deleteById(int id) {
        data.models.Visitor visitor = findById(id);
        if (visitor != null) {
            visitors.remove(visitor);
        }
    }

    @Override
    public void deleteByObject(data.models.Visitor visitor) {
        delete(visitor);
    }

    @Override
    public void deleteAll() {
        visitors.clear();
    }

    public int count() {
        return visitors.size();
    }
}