let mut x_y: [u32; 2] = [0, 0];
    for (i, line) in io::stdin().lock().lines().map(|r| r.unwrap()).enumerate() {
        let string_len = line.len();
        if string_len > 1 {
            x_y[i] = ((string_len - 1) / 3) as u32;
        }
    }
    let s_cnt = x_y[0] * x_y[1];
    let mut string = String::new();
    for _ in 0..s_cnt {
        string.push_str("S(");
    }
    string.push('0');
    for _ in 0..s_cnt {
        string.push(')');
    }
    println!("{}", string);