for i in io::stdin()
        .lock()
        .lines()
        .skip(1)
        .map(|l| l.unwrap())
        .collect::<Vec<String>>()
        .iter()
        .rev()
    {
        println!("{}", i);
    }