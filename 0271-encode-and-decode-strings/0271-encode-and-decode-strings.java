public class Codec {

    public String encode(List<String> strs) {
        return strs.stream()
                   .map(s -> s.replace("#", "##") + " # ")
                   .collect(Collectors.joining());
    }

    public List<String> decode(String s) {
        List strs = Stream.of(s.split(" # ", -1))
                          .map(t -> t.replace("##", "#"))
                          .collect(Collectors.toList());
        strs.remove(strs.size() - 1);
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));