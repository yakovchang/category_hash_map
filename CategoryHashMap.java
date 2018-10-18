import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CategoryHashMap<F, K, V> {

    private HashMap<F, HashMap<K, V>> map = new HashMap<>();

    public int size() {
        int size = 0;
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                size = size + entry.getValue().size();
            }
        }
        return size;
    }

    public int size(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.size parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? 0 : categoryMap.size();
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().size() > 0) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    public boolean isEmpty(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.isEmpty parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? true : categoryMap.isEmpty();
    }

    public boolean containsCategory(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.containsCategory parameter category must be not null");
        }
        return map.containsKey(category);
    }

    public boolean containsKey(K key) {
        boolean contains = false;
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().containsKey(key)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public boolean containsKey(F category, K key) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.containsKey parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? false : categoryMap.containsKey(key);
    }

    public boolean containsValue(V value) {
        boolean contains = false;
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().containsValue(value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public boolean containsValue(F category, V value) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.containsValue parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? false : categoryMap.containsValue(value);
    }

    public HashMap<K, V> getCategory(F category) {
        return map.get(category);
    }


    public HashMap<K, V> removeCategory(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.removeCategory parameter category must be not null");
        }
        return map.remove(category);
    }

    public V get(F category, K key) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.get parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? null : categoryMap.get(key);
    }

    public void remove(K key) {
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().remove(key);
            }
        }
    }

    public V remove(F category, K key) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.remove parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? null : categoryMap.remove(key);
    }

    public void putAll(F category, HashMap<K, V> categoryMap) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.putAll parameter category must be not null");
        }
        map.put(category, categoryMap);
    }

    public HashMap<K, V> addAll(F category, HashMap<K, V> categoryMap) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.addAll parameter category must be not null");
        }
        HashMap<K, V> categoryMapOld = map.get(category);
        if (categoryMapOld == null) {
            return map.put(category, categoryMap);
        } else {
            categoryMapOld.putAll(categoryMap);
            map.put(category, categoryMapOld);
            return categoryMapOld;
        }
    }

    public void clear() {
        map.clear();
    }

    public Set<F> categorySet() {
        return map.keySet();
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().keySet().size() > 0) {
                set.addAll(entry.getValue().keySet());
            }
        }
        return set;
    }

    public Set<K> keySet(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.keySet parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? Collections.EMPTY_SET : categoryMap.keySet();
    }

    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().values().size() > 0) {
                collection.addAll(entry.getValue().values());
            }
        }
        return collection;
    }

    public Collection<V> values(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.values parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? Collections.EMPTY_SET : categoryMap.values();
    }


    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (Map.Entry<F, HashMap<K, V>> entry : map.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().entrySet().size() > 0) {
                set.addAll(entry.getValue().entrySet());
            }
        }
        return set;
    }

    public Set<Map.Entry<K, V>> entrySet(F category) {
        if (category == null) {
            throw new IllegalArgumentException("CategoryHashMap.entrySet parameter category must be not null");
        }
        HashMap<K, V> categoryMap = map.get(category);
        return categoryMap == null ? Collections.EMPTY_SET : categoryMap.entrySet();
    }
}
