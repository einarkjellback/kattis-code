let mut buf = String::new();
    io::stdin().read_line(&mut buf).unwrap();
    let n: u32 = buf.trim().parse().unwrap();
    if n % 2 == 0 {
        println!("Alice\n{}", n / 2);
    } else {
        println!("Bob");
    }