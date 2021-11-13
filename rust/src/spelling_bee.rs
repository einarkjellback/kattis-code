let mut alphabet = String::new();
    let stdin = io::stdin();
    stdin.read_line(&mut alphabet).unwrap();
    let mut alphabet = alphabet.chars();
    let center = alphabet.next().unwrap();
    let mut alphabet: HashSet<char> = alphabet.collect();
    alphabet.insert(center);
    let mut string = String::new();
    'outer: for word in stdin.lock().lines().skip(1) {
        let word = word.unwrap();
        if word.len() >= 4 && word.contains(center) {
            for c in word.chars() {
                if !alphabet.contains(&c) {
                    continue 'outer;
                }
            }
            string.push_str(&word);
            string.push('\n');
        }
    }
    print!("{}", string);