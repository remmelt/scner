```bash
alias npm='docker run -it --entrypoint npm -v ~/dev/side/scner/api/fe:/work -w /work node'
alias npx='docker run -it --entrypoint npx -v ~/dev/side/scner/api/fe:/work -w /work node'


npx eslint --fix  src/
```
