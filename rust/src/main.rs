use std::collections::HashMap;
use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut buf = String::new();
    stdin.read_line(&mut buf).unwrap();
    let cases = buf.trim().parse::<u32>().unwrap();

    for case in 0..cases {
        let valueCount = match stdin.read_line(&mut buf) {
            Ok(_) => buf.trim().parse::<u32>().unwrap(),
            Err(_) => 0
        };

        let values = match stdin.read_line(&mut buf) {
            Ok(_) => buf.split_whitespace().map(|v: &str| v.parse::<u32>().unwrap()),
            Err(_) => nil
        }
    }
}